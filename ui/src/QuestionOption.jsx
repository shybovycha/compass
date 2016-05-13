import React from 'react';

import RaisedButton from 'material-ui/RaisedButton';

export default React.createClass({
    propTypes: {
        value: React.PropTypes.string,
        optionId: React.PropTypes.string
    },

    render: function () {
        return (
            <RaisedButton>{ this.props.value }</RaisedButton>
        );
    }
});
