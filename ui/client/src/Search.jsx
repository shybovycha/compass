import React from 'react';

import Question from './Question';
import MatchedCourses from './MatchedCourses';

// import Stub from './Stub';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        var search = window.DataSource.searches.filter(search => this.props.params.id == search.id)[0];
        var answers = search.answers.map(a => Object.assign(a, { question: window.DataSource.questions.filter(q => q.id == a.question)[0] }));

        return {
            search: search,
            answers: answers
        };
    },

    render: function () {
        return (
            <div className="questionnaire container">
                <div className="col fill-parent">
                    <MatchedCourses title={ 'Completed on ' + this.state.search.createdAt } search={ this.state.search } expanded={ true } showLink={ false } />

                    { this.state.answers.map(answer => <Question {...answer.question} answer={answer.answer} />) }
                </div>
            </div>
        );
    }
});