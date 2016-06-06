import React from 'react';

import RaisedButton from 'material-ui/RaisedButton';

import MatchedOrgs from './MatchedOrgs';
import MatchedCourses from './MatchedCourses';

import Question from './Question';
import Icon from './Icon';

// import Stub from './Stub';

import qwest from 'qwest';

export default React.createClass({
    propTypes: {
        title: React.PropTypes.string,
        questions: React.PropTypes.array
    },

    getInitialState: function () {
        return {
            // hardcode
            questions: window.DataSource.questions,
            currentQuestion: 0,
            matchedOrgs: 0
        };
    },

    getQuestion: function () {
        // hardcode here for MVP
        return this.state.questions[this.state.currentQuestion];
    },

    nextQuestion: function () {
        debugger;
        var searchId = this.getSearch().id;
        var questionId = this.getQuestion().id;
        var questionOptionId = this.getQuestion().answer;

        qwest.post('/answers/create', { search_id: searchId, question_id: questionId, question_option_id: questionOptionId })
            .then((_xht, _data) => {
                return qwest.get('/match/' + searchId);
            })
            .then((_xhr, data) => {
                debugger;
                this.setState({
                    currentQuestion: (this.state.currentQuestion + 1) % this.state.questions.length,
                    matchedOrgs: data
                });
            })
            .catch(function (msg) {
                console.error('Error during data fetch occured:', msg);
            });
    },

    getSearch: function () {
        return JSON.parse(window.localStorage.getItem('search')) || { id: null };
    },

    currentAnswerChanged: function (newAnswer) {
        var question = this.getQuestion();
        question.answer = newAnswer;
    },

    render: function () {
        return (
            <div className="questionnaire container col">
                <div className="col fill-parent">
                    { this.state.matchedOrgs > 0 ? <MatchedCourses title="Matched so far" search={ this.getSearch() } /> : '' }

                    <Question onAnswerChanged={ this.currentAnswerChanged } {...this.getQuestion()} />
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