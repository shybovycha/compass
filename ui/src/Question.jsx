import React from 'react';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';

import RadioOptions from './RadioOptions';
import CheckboxOptions from './CheckboxOptions';

export default React.createClass({
    propTypes: {
        imgUrl: React.PropTypes.string,
        content: React.PropTypes.string,
        style: React.PropTypes.oneOf([ 'SINGLE_CHOICE', 'MULTIPLE_CHOICE', 'RANKING' ]),
        options: React.PropTypes.array
    },

    getInitialState: function () {
        return {
            answer: []
        };
    },

    // onAnswerSubmitted: function (answer) {
    //     this.setState({ answer: answer });
    // },

    getOptions: function () {
        if (this.props.style == 'SINGLE_CHOICE')
            return <RadioOptions options={ this.props.options } />;
        else if (this.props.style == 'MULTIPLE_CHOICE')
            return <CheckboxOptions options={ this.props.options } />;
        // else if (this.props.style == 'RANKING')
        //     return <RankingOptions options={ this.props.options } />;
    },

    getImage: function () {
        return this.props.imgUrl && (
            <CardMedia>
                <img src={ this.props.imgUrl } />
            </CardMedia>
        );
    },

    getContent: function () {
        return this.content && 
            <CardText>
                { this.props.content }
            </CardText>;
    },
    
    render: function () {
        return (
            <Card>
                { this.getImage() }

                <CardTitle title={ this.props.title } />
                
                { this.getContent() }
                
                <CardActions>
                    { this.getOptions() }
                </CardActions>
            </Card>
        );
    }
});
