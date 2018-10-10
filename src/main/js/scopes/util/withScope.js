import React from "react"

export default function(Component)
{
    return class extends React.Component {

        render()
        {
            return (
                <Component
                    scope={(
                        {
                            nichtWirklich: true
                        }
                    )}
                    { ... this.props }
                >
            )
        }
    }
};
