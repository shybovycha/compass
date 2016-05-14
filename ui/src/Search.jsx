import React from 'react';

import Question from './Question';
import MatchedOrgs from './MatchedOrgs';

import Stub from './Stub';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        return {
            // hardcode here
            search: Stub.searches.filter(search => this.props.params.id == search.id)[0]
        };
    },

    render: function () {
        return (
            <div className="questionnaire container">
                <div className="col fill-parent">
                    <MatchedOrgs title={ 'Completed on ' + this.state.search.createdAt } search={ this.state.search } expanded={ true } showLink={ false } />

                    { this.state.search.answers.map(answer => <Question {...answer.question} answer={answer.answer} />) }
                </div>
            </div>
        );
    }
});