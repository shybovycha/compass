import React from 'react';
import { Router, Route, Link, hashHistory } from 'react-router';

import AppBar from 'material-ui/AppBar';
import IconButton from 'material-ui/IconButton';
import Drawer from 'material-ui/Drawer';
import MenuItem from 'material-ui/MenuItem';
import Avatar from 'material-ui/Avatar';

import DrawerMenu from './DrawerMenu';

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
                <AppBar
                    title={ this.props.title }
                    iconElementLeft={
                        <IconButton onClick={ this.toggleDrawerMenu }>
                            <Icon light={ true } name="menu" />
                        </IconButton>
                    } />

                <Drawer open={ this.state.showDrawer } docked={ false } onRequestChange={ this.toggleDrawerMenu } className="sidebar">
                    <MenuItem>
                        <div onClick={ this.goTo("/") } className="sidebar-item avatar">
                            <Avatar src={ this.props.user.imgUrl } size={ 80 } />
                            <div className="title">{ this.props.user.name }</div>
                            <div className="subtitle">{ this.props.user.email }</div>
                        </div>
                    </MenuItem>

                    <MenuItem>
                        <div onClick={ this.goTo("/courses") } className="sidebar-item">
                            <Icon name="explore" />
                            <span>Courses</span>
                        </div>
                    </MenuItem>

                    <MenuItem>
                        <div onClick={ this.goTo("/questions") } className="sidebar-item">
                            <Icon name="speaker_notes" />
                            <span>Questions</span>
                        </div>
                    </MenuItem>

                    <MenuItem>
                        <div onClick={ this.goTo("/orgs") } className="sidebar-item">
                            <Icon name="work" />
                            <span>Organizations</span>
                        </div>
                    </MenuItem>
                </Drawer>
            </div>
        )
    }
});