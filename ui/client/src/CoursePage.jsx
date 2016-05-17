import React from 'react';
import { hashHistory } from 'react-router';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';

import Question from './Question';
import Icon from './Icon';

// import Stub from './Stub';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        var course = window.DataSource.courses.filter(c => c.id == this.props.params.id)[0];
        var orgs = window.DataSource.organizations.filter(o => o.courses.map(c => c.id).indexOf(course.id) > -1);

        return {
            // hardcode here
            course: course,
            orgs: orgs
        };
    },

    showOrg: function (org) {
        hashHistory.push('/org/' + org.id);
    },

    render: function () {
        return (
            <div className="container">
                <Card className="organization">
                    <CardTitle title={ this.state.course.title } />

                    <CardText>
                        <div dangerouslySetInnerHTML={{ __html: this.state.course.description }}></div>

                        <div>
                            <h3>Universities, offering this course:</h3>

                            { this.state.orgs.map(o =>
                                <div className="margin-top">
                                    <RaisedButton
                                        onClick={ () => this.showOrg(o) }
                                        label={ o.title }
                                        labelPosition="before"
                                        icon={ <Icon name="public" /> }
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