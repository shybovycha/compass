import React from 'react';
import { Link } from 'react-router';

import RaisedButton from 'material-ui/RaisedButton';
import IconButton from 'material-ui/IconButton';
import Drawer from 'material-ui/Drawer';
import Menu from 'material-ui/Menu';
import MenuItem from 'material-ui/MenuItem';

import Icon from './Icon';

export default React.createClass({
    propTypes: {
        user: React.PropTypes.object
    },

    render: function () {
        return (
            <div>
                <MenuItem leftIcon={ <Icon name="account_circle" /> } primaryText={ this.props.user.name } />
                <MenuItem leftIcon={ <Icon name="access_time" /> } primaryText={ "My searches" } />
                <MenuItem leftIcon={ <Icon name="search" /> } primaryText={ "New search" } />
            </div>
        );
    }
});
