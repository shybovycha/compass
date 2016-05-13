import React from 'react';

import AppBar from 'material-ui/AppBar';
import IconButton from 'material-ui/IconButton';

export default React.createClass({
    propTypes: {
        title: React.PropTypes.string,
        onClick: React.PropTypes.func
    },

    render: function () {
        return (
            <AppBar
                title={ this.props.title }
                iconElementLeft={ <IconButton onClick={ this.props.onClick }> <i className="material-icons md-light md-36">menu</i> </IconButton> } />
        );
    }
});