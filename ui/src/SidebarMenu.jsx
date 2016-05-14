import React from 'react';
import { Router, Route, Link, hashHistory } from 'react-router';

import Drawer from 'material-ui/Drawer';
import MenuItem from 'material-ui/MenuItem';
import Avatar from 'material-ui/Avatar';

import DrawerMenu from './DrawerMenu';
import NavBar from './NavBar';

import Icon from './Icon';

export default React.createClass({
    propType: {
        user: React.PropTypes.object,
        title: React.PropTypes.string
    },

    getInitialState: function () {
        return {
            showDrawer: false
        };
    },

    toggleDrawerMenu: function () {
        this.setState({ showDrawer: !this.state.showDrawer });
    },

    goTo: function (path) {
        return () => {
            this.toggleDrawerMenu();
            hashHistory.push(path);
        }
    },

    render: function () {
        return (
            <div>
                <NavBar title={ this.props.title } onClick={ this.toggleDrawerMenu } />

                <Drawer open={ this.state.showDrawer } docked={ false } onRequestChange={ this.toggleDrawerMenu } className="sidebar">
                    <MenuItem>
                        <div onClick={ this.goTo("/account") } className="sidebar-item avatar">
                            <Avatar src={ this.props.user.imgUrl } size={ 80 } />
                            <div className="title">{ this.props.user.name }</div>
                            <div className="subtitle">{ this.props.user.email }</div>
                        </div>
                    </MenuItem>

                    <MenuItem>
                        <div onClick={ this.goTo("/searches") } className="sidebar-item">
                            <Icon name="access_time" />
                            <span>My searches</span>
                        </div>
                    </MenuItem>

                    <MenuItem>
                        <div onClick={ this.goTo("/questionnaire") } className="sidebar-item">
                            <Icon name="search" />
                            <span>New search</span>
                        </div>
                    </MenuItem>
                </Drawer>
            </div>
        )
    }
});