import React from 'react';
import { hashHistory } from 'react-router';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';

import Icon from './Icon';

import Stub from './Stub';

export default React.createClass({
    propTypes: {
        search: React.PropTypes.object,
        title: React.PropTypes.string,
        expanded: React.PropTypes.bool,
        showLink: React.PropTypes.bool,
        maxItems: React.PropTypes.number
    },

    getDefaultProps: function () {
        return {
            expanded: false,
            showLink: true,
            maxItems: 3
        };
    },

    getInitialState: function () {
        var search = this.props.search;
        var courses = Stub.courses.filter(c => search.matchedCourses.indexOf(c.id) > -1);

        return {
            search: search,
            courses: courses
        };
    },

    showSearch: function () {
        hashHistory.push('/search/' + this.state.search.id);
    },

    showCourse: function (course) {
        hashHistory.push('/course/' + course.id);
    },

    render: function () {
        return (
            <Card className="question" initiallyExpanded={ this.props.expanded }>
                { this.props.expanded ?
                    <CardHeader title={ this.props.title } /> :
                    <CardHeader title={ this.props.title } actAsExpander={ true } showExpandableButton={ true } />
                }

                <CardText expandable={ true }>
                    <div>Matched courses:</div>

                    { this.state.courses.slice(0, this.state.maxItems).map(course =>
                        <div className="margin-top">
                            <RaisedButton
                                onClick={ () => this.showCourse(course) }
                                label={ course.title }
                            />
                        </div>
                    ) }
                </CardText>

                { this.props.showLink == false ? '' :
                    <CardActions expandable={ true }>
                        <RaisedButton
                            icon={ <Icon name="keyboard_arrow_right" /> }
                            onClick={ this.showSearch }
                            label="Details"
                            labelPosition="before"
                            backgroundColor="#a4c639"
                        />
                    </CardActions>
                }
            </Card>
        );
    }
});