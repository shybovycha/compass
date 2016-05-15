import React from 'react';

import Icon from './Icon';

export default React.createClass({
    propTypes: {
        stars: React.PropTypes.number,
        selected: React.PropTypes.number,
        onClick: React.PropTypes.func,
        size: React.PropTypes.number
    },

    getDefaultProps: function () {
        return {
            stars: 5,
            selected: 0,
            size: 36,
            onClick: (stars) => {}
        };
    },

    getInitialState: function () {
        return {
            selected: this.props.selected
        };
    },

    handleClick: function (stars) {
        this.setState({ selected: stars });
        this.props.onClick(this.state.selected);
    },

    getStars: function () {
        var result = [];

        for (let i = 0; i < this.props.stars; i++) {
            let clickHandler = () => this.handleClick(this.props.stars - i);
            let className = ((this.props.stars - i) <= this.state.selected) ? 'selected' : '';

            result.push(<Icon onClick={ clickHandler } name="star_border" size={ this.props.size } className={ className } />);
        }

        return result;
    },

    render: function () {
        return (
            <div className="rating">
                { this.getStars() }
            </div>
        );
    }
});