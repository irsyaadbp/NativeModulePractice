import React from 'react';
import PropTypes from 'prop-types';
import {requireNativeComponent, View} from 'react-native';

const CalendarView = props => {
  const onChange = event => {
    if (!props.onDateChange) {
      return;
    }
    props.onDateChange(event.nativeEvent);
  };

  return <CalendarNative {...props} onChange={onChange} />;
};

CalendarView.propTypes = {
  day: PropTypes.number,
  month: PropTypes.number,
  year: PropTypes.number,
  onDateChange: PropTypes.func,
  ...View.propTypes,
};
const CalendarNative = requireNativeComponent('CalendarNative', CalendarView, {
  nativeOnly: {
    onChange: true,
  },
});

export default CalendarView;
