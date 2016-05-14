import React from 'react';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';

import Question from './Question';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        return {
            // hardcode here
            org: [
                { id: '1', title: 'Munich Technological University', description: 'Munich ist der gut! Deutsch ist der gut!', url: 'http://google.com/search?q=Munich Technological University' },
                { id: '2', title: 'FHWien der WKW', description: 'Vienn is beautiful', url: 'http://google.com/search?q=FHWien der WKW' },
                { id: '3', title: 'EPAM Java Academy', description: 'EPAM provides great production experience and salaries', url: 'http://google.com/search?q=EPAM Java Academy' },
                { id: '4', title: 'Massachussets University Of Technology', description: 'Go for USA!', url: 'http://google.com/search?q=Massachussets University Of Technology' },
                { id: '5', title: 'Uniwersytet Jagielloński', description: 'Kraków is awesome! UJ provides great theoretical knowledge on IT.', url: 'http://google.com/search?q=Uniwersytet Jagielloński' },
                { id: '6', title: 'Akademia Górniczo-Huthicza', description: 'AGH provides awesome practical knowledge', url: 'http://google.com/search?q=Akademia Górniczo-Huthicza' },
                { id: '7', title: 'University Of Cambridge', description: 'This is Cambridge.', url: 'http://google.com/search?q=University Of Cambridge' },
                { id: '8', title: 'Politechnika Wrocławska', description: 'Wrocław is the cultural centre of Poland', url: 'http://google.com/search?q=Politechnika Wrocławska' }
            ].filter(o => o.id == this.props.params.id)[0]
        };
    },

    openOrgWebsite: function () {
        window.location.href = this.state.org.url;
    },

    render: function () {
        return (
            <div className="container">
                <Card className="organization">
                    <CardTitle title={ this.state.org.title } />
                    
                    <CardText>
                        { this.state.org.description }
                    </CardText>
                    
                    <CardActions>
                        <RaisedButton
                                onClick={ this.openOrgWebsite }
                                label="Website"
                                labelPosition="before"
                            />
                    </CardActions>
                </Card>
            </div>
        );
    }
});