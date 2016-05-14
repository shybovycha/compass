import React from 'react';

import RaisedButton from 'material-ui/RaisedButton';

import MatchedOrgs from './MatchedOrgs';
import Question from './Question';
import Icon from './Icon';

export default React.createClass({
    propTypes: {
        title: React.PropTypes.string,
        questions: React.PropTypes.array
    },

    getInitialState: function () {
        return {
            // hardcode
            questions: [
                { title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] },
                { title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] },
                { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }
            ],
            currentQuestion: 0,
            matchedOrgs: 0
        };
    },

    getQuestion: function () {
        // hardcode here for MVP
        return this.state.questions[this.state.currentQuestion];
    },

    nextQuestion: function () {
        this.setState({ currentQuestion: (this.state.currentQuestion + 1) % this.state.questions.length, matchedOrgs: this.state.matchedOrgs + 1 });
    },

    getSearch: function () {
        var searches = [
            { id: '1', createdAt: '2016-04-12', matchedOrgs: [ { id: '1', title: 'Munich Technological University' }, { id: '2', title: 'FHWien der WKW' }, { id: '3', title: 'EPAM Java Academy' } ] },
            { id: '2', createdAt: '2016-05-07', matchedOrgs: [ { id: '4', title: 'Massachussets University Of Technology' }, { id: '5', title: 'Uniwersytet Jagielloński' }, { id: '6', title: 'Akademia Górniczo-Huthicza' }, { id: '7', title: 'University Of Cambridge' } ] },
            { id: '3', createdAt: '2016-05-14', matchedOrgs: [ { id: '8', title: 'Politechnika Wrocławska' }, { id: '6', title: 'Akademia Górniczo-Huthicza'}, { id: '5', title: 'Uniwersytet Jagielloński' } ] }
        ];

        return searches[Math.floor(Math.random() * searches.length)];
    },

    render: function () {
        return (
            <div className="questionnaire container col">
                <div className="col fill-parent">
                    { this.state.matchedOrgs > 0 ? <MatchedOrgs title="Matched so far" search={ this.getSearch() } /> : '' }

                    <Question {...this.getQuestion()} />
                </div>

                <div className="row bottom-button">
                    <div className="col fill-parent hcenter">
                        <RaisedButton
                            icon={ <Icon name="keyboard_arrow_right" /> }
                            onClick={ this.nextQuestion }
                            label="Next question"
                            labelPosition="before"
                            backgroundColor="#a4c639"
                        />
                    </div>
                </div>
            </div>
        );
    }
});