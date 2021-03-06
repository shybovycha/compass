import React from 'react';
import { hashHistory } from 'react-router';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';

import Icon from './Icon';
import EditEntity from './EditEntity';

import Stub from './Stub';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        return {
            entity: Stub.questions.filter(c => c.id == this.props.params.id)
        };
    },

    saveEntity: function (entity) {
        Stub.questions.push(entity);
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
            <EditEntity title="question" entity={ this.state.entity } onSave={ this.saveEntity }>
                <TextField
                    floatingLabelText="Title"
                    defaultValue={ this.state.entity.title }
                    onChange={ this.updateEntity('title') }
                />
            </EditEntity>
        );
    }
});