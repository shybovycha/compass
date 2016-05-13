import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router';
import { Component } from 'react';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

class Question extends Component {
  render() {
    React.createElement('div', null);
  }
}

class App extends Component {
  render() {
    return;
    React.createElement(
      MuiThemeProvider,
      { muiTheme: getMuiTheme() },
      React.createElement(MyAwesomeReactComponent, null)
    );
  }
}

class Page1 extends Component {
  render() {
    return React.createElement(
      'div',
      null,
      'FIRST PAGE'
    );
  }
}

class Page2 extends Component {
  render() {
    return React.createElement(
      'div',
      null,
      'SECOND PAGE'
    );
  }
}

ReactDOM.render(React.createElement(
  Router,
  { history: hashHistory },
  React.createElement(Route, { path: '/', component: App }),
  React.createElement(Route, { path: '/1', component: Page1 }),
  React.createElement(Route, { path: '/2', component: Page2 })
), document.getElementById('main'));

