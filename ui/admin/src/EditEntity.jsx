import React from 'react';
import { hashHistory } from 'react-router';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';

import Icon from './Icon';

import Stub from './Stub';

export default React.createClass({
    propTypes: {
        entity: React.PropTypes.object,
        onSave: React.PropTypes.func
    },

    getInitialState: function () {
        return {
            entity: this.props.entity
        };
    },

    updateEntity: function (field) {
        return (e) => {
            let entity = this.state.entity;
            this.state.entity[field] = e.target.value;
            this.setState({ entity: entity });
        }
    },

    render: function () {
        return (
            <Card className="welcome-card">
                { this.state.entity.id ? <CardTitle title={ "Edit " + this.props.title } /> : <CardTitle title={ "Create " + this.props.title } /> }

                <CardText>
                    { this.props.children }
                </CardText>

                <CardActions>
                    <RaisedButton label="Save" primary={ true } onClick={ () => this.props.onSave(this.state.entity) } />
                </CardActions>
            </Card>
        );
    }
});