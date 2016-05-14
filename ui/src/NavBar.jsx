import React from 'react';

import AppBar from 'material-ui/AppBar';
import IconButton from 'material-ui/IconButton';

import Icon from './Icon';

export default React.createClass({
    propTypes: {
        title: React.PropTypes.string,
        onClick: React.PropTypes.func
    },

    render: function () {
        return (
            <AppBar
                title={ this.props.title }
                iconElementLeft={ 
                    <IconButton onClick={ this.props.onClick }> 
                        <Icon light={ true } name="menu" />
                    </IconButton> 
                } />
        );
    }
});