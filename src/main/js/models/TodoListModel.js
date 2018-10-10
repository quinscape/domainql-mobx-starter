import {
    observable,
    computed,
    action
} from "mobx";


export default class TodoListModel {

    /** {TodoInput} Current todos **/
    @observable todos = [];

    @observable blaId = [];

    stateMachine = {
            "startState": "A",
            "states": {
                "A": ["B"],
                "B": ["C"],
                "C": []
            }
        };

    @computed
    get unfinishedTodoCount()
    {
        return this.todos.filter(todo => !todo.finished).length;
    }

    @action
    on

    @action
    addTodo(title)
    {
        this.todos.push(new TodoModel(title));
    }
}
