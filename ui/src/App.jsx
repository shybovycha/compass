import React from 'react';
import ReactDOM from 'react-dom';

import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import IconButton from 'material-ui/IconButton';
import Drawer from 'material-ui/Drawer';
import MenuItem from 'material-ui/MenuItem';

import Dashboard from './Dashboard';
import DrawerMenu from './DrawerMenu';
import Questionnaire from './Questionnaire';
import NavBar from './NavBar';

const App = React.createClass({
    propTypes: {
        title: React.PropTypes.string,
        questions: React.PropTypes.array
    },

    getInitialState: function () {
        return {
            showDrawer: false,
            user: {
                name: 'USERNAME'
            }
        };
    },

    toggleDrawerMenu: function () {
        this.setState({ showDrawer: !this.state.showDrawer });
    },

    render: function () {
        return (
            <MuiThemeProvider muiTheme={ getMuiTheme() }>
                <div>
                    <NavBar title={ this.props.title } onClick={ this.toggleDrawerMenu } />

                    <Drawer open={ this.state.showDrawer } docked={ true }>
                        <NavBar title={ this.props.title } onClick={ this.toggleDrawerMenu } />

                        <DrawerMenu user={ this.state.user } />
                    </Drawer>

                    <Questionnaire questions={ this.props.questions } />
                </div>
            </MuiThemeProvider>
        );
    }
});

var questions = [
    { title: 'question 1', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] },
    { title: 'q2', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] },
    { title: 'q3', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }
];

ReactDOM.render(
    <App title="Compass" questions={ questions } />,
    document.getElementById('app')
);