import React from "react";
import bootstrap from "jsview-bootstrap"

import DevTools from "mobx-react-devtools";

import TodoList from "./components/TodoList";
import TodoListModel from "./models/TodoListModel";


const store = new TodoListModel();


store.addTodo("Get Coffee");
store.addTodo("Write simpler code");
store.todos[0].finished = true;

setTimeout(() => {
    store.addTodo("Get a cookie as well");
}, 2000);

// playing around in the console
window.store = store;



bootstrap(
    initial => (
        <div className="container">
            <div className="row">
                <div className="col">
                    <TodoList store={store} />
                </div>
            </div>
            <DevTools />
        </div>
    )
)
