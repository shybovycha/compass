import React from 'react';
import { hashHistory } from 'react-router';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';

import Question from './Question';
import Icon from './Icon';

import Stub from './Stub';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        var org = Stub.organizations.filter(o => o.id == this.props.params.id)[0];
        var courses = Stub.courses.filter(c => org.courses.indexOf(c.id) > -1);

        return {
            // hardcode here
            org: org,
            courses: courses
        };
    },

    openOrgWebsite: function () {
        window.location.href = this.state.org.url;
    },

    showCourse: function (course) {
        hashHistory.push('/course/' + course.id);
    },

    render: function () {
        return (
            <div className="container">
                <Card className="organization">
                    <CardTitle title={ this.state.org.title } />

                    <CardText>
                        <div>
                            { this.state.org.description }
                        </div>

                        <h3>Courses offered:</h3>

                        <div>
                            { this.state.courses.map(c =>
                                <div className="margin-top">
                                    <RaisedButton
                                        onClick={ () => this.showCourse(c) }
                                        label={ c.title }
                                        labelPosition="before"
                                        icon={ <Icon name="info" /> }
                                        primary={ true }
                                    />
                                </div>
                            ) }
                        </div>
                    </CardText>
                </Card>
            </div>
        );
    }
});