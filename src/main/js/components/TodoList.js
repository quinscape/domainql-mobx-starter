import React from "react";
import {
    observable,
    action  
} from "mobx";
import { observer } from "mobx-react";

import Todo from "./Todo";


@observer
class TodoList extends React.Component {
    @observable newTodoTitle = "";

    render()
    {
        return (
            <div>
                <form className="form " onSubmit={ this.handleFormSubmit }>
                    <div className="form-group row">
                        <label htmlFor="newTodoField" className="col-sm-2 col-form-label">New Todo:</label>
                        <div className="col-sm-10">

                            <div className="input-group mb-3">
                                <input
                                    type="text"
                                    className="form-control"
                                    id="newTodoField"
                                    value={ this.newTodoTitle }
                                    onChange={ this.handleInputChange }
                                />
                                <div className="input-group-append">
                                    <button type="submit" className="btn btn-secondary">Add</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <hr/>
                <ul>
                    {
                        this.props.store.todos.map(todo => (
                            <Todo
                                key={ todo.id }
                                todo={ todo }
                            />
                        ))
                    }
                </ul>
                Tasks left: { this.props.store.unfinishedTodoCount }
            </div>
        );
    }

    @action
    handleInputChange = e => {
        this.newTodoTitle = e.target.value;
    };

    @action
    handleFormSubmit = e => {
        this.props.store.addTodo(this.newTodoTitle);
        this.newTodoTitle = "";
        e.preventDefault();
    };
}

export default TodoList;
