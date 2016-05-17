import React from 'react';
import { hashHistory } from 'react-router'

import RaisedButton from 'material-ui/RaisedButton';

import MatchedCourses from './MatchedCourses';

// import Stub from './Stub';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        return {
            searches: window.DataSource.searches
        };
    },

    startQuestionnaire: function () {
        hashHistory.push('/questionnaire');
    },

    render: function () {
        return (
            <div className="container col">
                <div className="hcenter">
                    { this.state.searches.map(search => <MatchedCourses search={ search } title={ 'Completed on ' + search.createdAt } expanded={ true } />) }
                </div>
            </div>
        );
    }
});
