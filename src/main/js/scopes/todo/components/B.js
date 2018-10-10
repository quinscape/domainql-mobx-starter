import React from "react"
import { observer } from "mobx-react";

import withScope from "../../util/withScope"

@observer
class B extends React.Component {

    loadFoo = id => {

        const { scope } = this.props;

        // language=GraphQL
        graphql(
            `
                query getFoo($fooId: String!) {
                    getFoo(id: $fooId)
                    {
                        name,
                        num
                    }
                }
            `, {
                fooId : id
            }
        ).then( ({getFoo}) => {
            this.props.scope.updateFoo(getFoo);
        }, defaultErrorHandler)
    };


    render()
    {

        const { scope } = this.props;


        return (
            <div>
                <h1> B </h1>
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

export default withScope(B)
