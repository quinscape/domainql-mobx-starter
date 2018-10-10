import {
    observable,
    computed,
    action
} from "mobx";

import ViewDing from "../util/ViewDing";

export const VIEWS = ViewDing(
    require.context("./views/", true, /\.js$/)
);

    export const STATES = (process, scope) => ({
    "startState": "A",
    "states": {
        "A": [
            {
                to: "B",
                action: scope.addTodo
            }
        ],
        "B": [
            {
                to: ["C", "D", "E"],
                action: () => {
                    todo.one();
                    if (scope.flag)
                    {
                        process.transition("C")
                    }
                }
            }
        ],
        "C": [
            {
                ... RESUSED_TRANSITION,
                to: "D"

            }
        ]
    }
});

export default class TodoScope {

    /** {TodoInput} Current todos **/
    @observable todos = [];


    @observable blaId = [];
    @observable preload = {
        query: `
       
        `
    };


    @computed
    get unfinishedTodoCount()
    {
        return this.
        todos.filter(todo => !todo.finished).length;
    }

    // variante 2
    @action
    updateFooAlt(foo)
    {
        this.currentFoo = foo;
    }
}
