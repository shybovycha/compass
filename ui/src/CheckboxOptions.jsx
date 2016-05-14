import React from 'react';

import Checkbox from 'material-ui/Checkbox';

import QuestionOption from './QuestionOption';

export default React.createClass({
    propTypes: {
        options: React.PropTypes.array,
        disabled: React.PropTypes.boolean,
        checked: React.PropTypes.array
    },
    
    render: function () {
        return (
            <div>
                { this.props.options.map(option => <Checkbox 
                    value={ option.optionId } 
                    label={ option.value } 
                    defaultChecked={ this.props.checked.indexOf(option.optionId) > -1 } 
                    disabled={ this.props.disabled } />
                    )
                }
            </div>
        );
    }
});
