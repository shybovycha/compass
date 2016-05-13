import React from 'react';

import Questionnaire from './Questionnaire';

// import {fullWhite} from 'material-ui/styles/colors';
// import FontIcon from 'material-ui/FontIcon';

export default React.createClass({
    propTypes: {
        title: React.PropTypes.string
    },

    state: {
        showDrawer: true
    },

    render: function () {
        return (
            <div>
                <Questionnaire />
            </div>
        );
    }
})
