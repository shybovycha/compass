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
import NavBar from './NavBar';

import Questionnaire from './Questionnaire';
import Search from './Search';

const App = React.createClass({
    propTypes: {
        title: React.PropTypes.string,
        questions: React.PropTypes.array,
        answers: React.PropTypes.array
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

                    {<Questionnaire questions={ this.props.questions } />}
                    {/*<Search answers={ this.props.answers } />*/}
                </div>
            </MuiThemeProvider>
        );
    }
});

var questions = [
    { title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] },
    { title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] },
    { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }
];

var answers = [
    { question: { title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] }, answer: ['q1o2'] },
    { question: { title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] }, answer: ['q2o1', 'q2o2'] },
    { question: { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o3'] },
    { question: { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=4&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o3'] },
    { question: { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=5&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o3'] }
];

ReactDOM.render(
    <App title="Compass" questions={ questions } answers={ answers } />,
    document.getElementById('app')
);