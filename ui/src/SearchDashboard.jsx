import React from 'react';
import { hashHistory } from 'react-router'

import RaisedButton from 'material-ui/RaisedButton';

import SearchDashboardEntry from './SearchDashboardEntry';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        return {
            searches: [
                { id: '1', createdAt: '2016-04-12', matchedOrgs: [ { id: '1', title: 'Munich Technological University' }, { id: '2', title: 'FHWien der WKW' }, { id: '3', title: 'EPAM Java Academy' } ] },
                { id: '2', createdAt: '2016-05-07', matchedOrgs: [ { id: '4', title: 'Massachussets University Of Technology' }, { id: '5', title: 'Uniwersytet Jagielloński' }, { id: '6', title: 'Akademia Górniczo-Huthicza' }, { id: '7', title: 'University Of Cambridge' } ] },
                { id: '3', createdAt: '2016-05-14', matchedOrgs: [ { id: '8', title: 'Politechnika Wrocławska' }, { id: '6', title: 'Akademia Górniczo-Huthicza'}, { id: '5', title: 'Uniwersytet Jagielloński' } ] }
            ]
        };
    },

    startQuestionnaire: function () {
        hashHistory.push('/questionnaire');
    },

    render: function () {
        return (
            <div className="container col">
                <div className="hcenter">
                    { this.state.searches.map(search => <SearchDashboardEntry search={ search } />) }
                </div>
            </div>
        );
    }
});
