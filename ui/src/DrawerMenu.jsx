import React from 'react';

import RaisedButton from 'material-ui/RaisedButton';
import IconButton from 'material-ui/IconButton';
import Drawer from 'material-ui/Drawer';
import MenuItem from 'material-ui/MenuItem';

export default React.createClass({
    propTypes: {
        user: React.PropTypes.object
    },

    render: function () {
        return (
            <div>
                <MenuItem>{ this.props.user.name }</MenuItem>
                <MenuItem>My searches</MenuItem>
                <MenuItem>New search</MenuItem>
            </div>
        );
    }
});
