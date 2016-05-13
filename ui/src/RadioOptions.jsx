import React from 'react';

import {RadioButton, RadioButtonGroup} from 'material-ui/RadioButton';

import QuestionOption from './QuestionOption';

export default React.createClass({
    propTypes: {
        options: React.PropTypes.array
    },

    render: function () {
        return (
            <RadioButtonGroup>
                { this.props.options.map(option => <RadioButton value={ option.optionId } label={ option.value } />)}
            </RadioButtonGroup>
        );
    }
});
