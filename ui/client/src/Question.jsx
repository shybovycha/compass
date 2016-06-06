import React from 'react';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';

import RadioOptions from './RadioOptions';
import CheckboxOptions from './CheckboxOptions';

export default React.createClass({
    propTypes: {
        imgUrl: React.PropTypes.string,
        content: React.PropTypes.string,
        style: React.PropTypes.oneOf([ 'SINGLE_CHOICE', 'MULTIPLE_CHOICE', 'RANKING', 'RANGING' ]),
        options: React.PropTypes.array,
        answer: React.PropTypes.array,
        onAnswerChanged: React.PropTypes.func
    },

    getInitialState: function () {
        return {
            answer: this.props.answer || [],
            disabled: typeof(this.props.answer) !== 'undefined'
        };
    },

    onOptionChanged: function (evt, newValue) {
        this.props.onAnswerChanged(newValue);
    },

    getOptions: function () {
        // this should eventually be split into three different input controls
        if (this.props.style == 'SINGLE_CHOICE' || this.props.style == 'RANKING' || this.props.style == 'RANGING')
            return <RadioOptions
                options={ this.props.options }
                disabled={ this.state.disabled }
                checked={ this.state.answer }
                onChange={ this.onOptionChanged } />;

        else if (this.props.style == 'MULTIPLE_CHOICE')
            return <CheckboxOptions
                options={ this.props.options }
                disabled={ this.state.disabled }
                checked={ this.state.answer }
                onChange={ this.onOptionChanged } />;

        // else if (this.props.style == 'RANKING')
        //     return <RankingOptions options={ this.props.options } />;
    },

    getImage: function () {
        if (!this.props.imgUrl)
            return '';

        return (
            <CardMedia>
                <img src={ this.props.imgUrl } />
            </CardMedia>
        );
    },

    getContent: function () {
        if (!this.content)
            return '';

        return (
            <CardText>
                { this.props.content }
            </CardText>
        );
    },

    render: function () {
        return (
            <Card className="question">
                { this.getImage() }

                <CardTitle title={ this.props.title } />

                <div dangerouslySetInnerHTML={{ __html: this.getContent() }}></div>

                <CardActions>
                    { this.getOptions() }
                </CardActions>
            </Card>
        );
    }
});
