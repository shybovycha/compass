import React from 'react';
import { hashHistory } from 'react-router';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';

import Icon from './Icon';

// import Stub from './Stub';

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
        var courses = this.props.search.matchedCourses || [];

        /*if (courses.length > 0 && typeof(courses[0]['id']) === 'undefined')
            courses = window.DataSource.courses.filter(c => search.matchedCourses.indexOf(c.id) > -1);*/

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
                    <div className="course-list">
                        { this.props.search.matchedCourses.slice(0, this.state.maxItems).map(course =>
                            <div className="margin-left margin-top course-list-item">
                                <RaisedButton
                                    onClick={ () => this.showCourse(course) }
                                    label={ course.title }
                                />
                            </div>
                        ) }
                    </div>
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
