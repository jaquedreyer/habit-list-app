package com.dreyer.meutreinodocurso.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.dreyer.meutreinodocurso.core.HabitsRepository

/**
 * @see [https://developer.android.com/topic/libraries/architecture/viewmodel]
 */

/** dentro da classe que estende de viewmodel vou declarar o livedata
 * sempre que algo sofrer modificação, add habito, hab excluido, etc o fragment vai observar a mudanca e
 * e avisar o adapter que entao vai comunicar o recyclerview pra atualizar na tela
 */

//nosso viewmodel vai importar o repository criado
class HabitListViewModel (private val repository: HabitsRepository) : ViewModel() {
    //declarar uistate
    //by lazy só vai instanciar a primeira vez que alguem chamar essa propriedade
    private val uiState: MutableLiveData<UiState> by lazy {
        MutableLiveData<UiState>(UiState(habitItemList = repository.fetchHabits()))
    }

    //expor as propriedades de forma imutable, pois
    // nao queremos que o fragment possa modificar o state
    //apenas quero que o fragment observe o estado que ta vindo do viewmodel e pedir pro viewmodel fazer modificacoes nesse estado
    //depois dos : especifico o tipo de retorno
    fun stateOnceAndStream() : LiveData<UiState> = uiState

    //funcao que vai ser chamada pela activity - onde está o FAB
    fun addRandomHabit() {
        repository.addRandomNewHabit()
        refreshUiState()
    }

//salvar habito como concluido
    fun toggleHabitCompleted(habitId: String){
        repository.toggleHabitCompleted(habitId)
        refreshUiState()
    }

    //permite atualizar a lista dentro do UiState
    private fun refreshUiState() {
        uiState.value?.let { currentUiState ->
            uiState.value = currentUiState.copy(
                habitItemList = repository.fetchHabits().sortedBy { it.isCompleted }
            )
        }
    }

    //UI State contendo todos dados necessarios para mostrar a lista
    //o nosso estado tem uma propriedade que é a lista de habitos habitItemList
    data class UiState(val habitItemList: List<HabitItem>)



    //criar um factory do viewmodel
    //factory é um design pattern
    //ViewModel Factory needed to provide Repository injection to ViewModel
    //depois isso pode ser usado pelo fragment pra criar uma instancia desse viewmodel
    //a classe recebe o repositorio no seu construtor e vai estender de viewmodelprovider
    class Factory(private val repository: HabitsRepository) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            return HabitListViewModel(repository) as T
        }
    }

}