import React from "react";
import { observer } from "mobx-react";

@observer
class Todo extends React.Component {

    render()
    {
        const {todo} = this.props;

        const id = "cb-" + todo.id;
        return (
            <li>
            <span className="form-check">
                <input
                    type="checkbox"
                    className="form-check-input"
                    id={id}
                    checked={todo.finished}
                    onChange={() => (todo.finished = !todo.finished)}
                />
                <label
                    className="form-check-label"
                    htmlFor={id}>
                    {
                        todo.title
                    }
                </label>
            </span>
            </li>
        );
    }
}

export default Todo
