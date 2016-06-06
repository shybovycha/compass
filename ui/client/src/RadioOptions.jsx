import React from 'react';

import {RadioButton, RadioButtonGroup} from 'material-ui/RadioButton';

export default React.createClass({
    propTypes: {
        options: React.PropTypes.array,
        disabled: React.PropTypes.bool,
        checked: React.PropTypes.array,
        onChange: React.PropTypes.func
    },

    render: function () {
        return (
            <RadioButtonGroup defaultSelected={ this.props.checked[0] } name="answer" onChange={ this.props.onChange }>
                { this.props.options.map((option, i) =>
                    <RadioButton
                        key={ i.toString() }
                        value={ option.id.toString() }
                        label={ option.value }
                        disabled={ this.props.disabled } />
                    )
                }
            </RadioButtonGroup>
        );
    }
});
