import React from 'react';

import Rating from './Rating';

export default React.createClass({
    propTypes: {
        options: React.PropTypes.array,
        disabled: React.PropTypes.bool,
        checked: React.PropTypes.array
    },

    render: function () {
        return (
            <Rating selected={ this.props.checked[0] } stars={ this.props.options.length } />
        );
    }
});
