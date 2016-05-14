import React from 'react';

import {RadioButton, RadioButtonGroup} from 'material-ui/RadioButton';

import QuestionOption from './QuestionOption';

export default React.createClass({
    propTypes: {
        options: React.PropTypes.array,
        disabled: React.PropTypes.boolean,
        checked: React.PropTypes.array
    },

    render: function () {
        return (
            <RadioButtonGroup defaultSelected={ this.props.checked[0] }>
                { this.props.options.map(option => 
                    <RadioButton 
                        value={ option.optionId } 
                        label={ option.value } 
                        disabled={ this.props.disabled } />
                    )
                }
            </RadioButtonGroup>
        );
    }
});
