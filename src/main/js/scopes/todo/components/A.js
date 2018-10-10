import React from "react"
import { observer } from "mobx-react";

import withScope from "../../util/withScope"

@observer
class A extends React.Component {

    loadFoo = id => {

        const { scope } = this.props;

        scope.getFoo(id);

    };


    render()
    {

        const { scope } = this.props;


        return (
            <div>
                <h1> A </h1>
                {
                    JSON.stringify(scope.currentFoo)
                }
                <button
                    type="button"
                    className="btn btn-primary"
                    onClick={ ev => this.loadFoo("aaa")}
                >
                    Load Foo
                </button>
            </div>
        )
    }
}

export default withScope(A)
