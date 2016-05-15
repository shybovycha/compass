import React from 'react';

import Question from './Question';
import MatchedOrgs from './MatchedOrgs';

import Stub from './Stub';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        var search = Stub.searches.filter(search => this.props.params.id == search.id)[0];
        var answers = search.answers.map(a => Object.assign(a, { question: Stub.question.filter(q => q.id == a.question) }));

        return {
            // hardcode here
            search: search,
            questions: answers
        };
    },

    render: function () {
        return (
            <div className="questionnaire container">
                <div className="col fill-parent">
                    <MatchedOrgs title={ 'Completed on ' + this.state.search.createdAt } search={ this.state.search } expanded={ true } showLink={ false } />

                    { this.state.answers.map(answer => <Question {...answer.question} answer={answer.answer} />) }
                </div>
            </div>
        );
    }
});