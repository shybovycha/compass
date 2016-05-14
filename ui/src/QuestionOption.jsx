import React from 'react';

import RaisedButton from 'material-ui/RaisedButton';

export default React.createClass({
    propTypes: {
        value: React.PropTypes.string,
        optionId: React.PropTypes.string,
        checked: React.PropTypes.boolean,
        disabled: React.PropTypes.boolean
    },

    render: function () {
        return (
            <RaisedButton defaultChecked={ this.props.checked } disabled={ this.props.disabled }>{ this.props.value }</RaisedButton>
        );
    }
});
