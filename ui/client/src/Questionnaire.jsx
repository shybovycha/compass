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
            questions: this.props.questions || window.DataSource.questions,
            currentQuestion: 0,
            matchedOrgs: 0,
            search: JSON.parse(window.localStorage.getItem('search') || "{}")
        };
    },

    getQuestion: function () {
        // hardcode here for MVP
        return this.state.questions[this.state.currentQuestion];
    },

    nextQuestion: function () {
        var searchId = this.state.search.id;
        var questionId = this.getQuestion().id;
        var questionOptionId = this.getQuestion().answer;
        var that = this;

        qwest.post('/answers/create', { search_id: searchId, question_id: questionId, question_option_id: questionOptionId })
            .then((_xht, _data) => {
                return qwest.get('/match/' + searchId);
            })
            .then((_xhr, data) => {
                debugger;

                that.state.search.matchedCourses = data;

                that.setState({
                    currentQuestion: (that.state.currentQuestion + 1) % that.state.questions.length,
                    matchedOrgs: data.length
                });
            })
            .catch(function (msg) {
                console.error('Error during data fetch occured:', msg);
            });
    },

    currentAnswerChanged: function (newAnswer) {
        var question = this.getQuestion();
        question.answer = newAnswer;
    },

    render: function () {
        return (
            <div className="questionnaire container col">
                <div className="col fill-parent">
                    { this.state.matchedOrgs > 0 ? <MatchedCourses title="Matched so far" search={ this.state.search } /> : '' }

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