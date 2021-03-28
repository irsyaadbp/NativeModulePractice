/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import * as React from 'react';
import {Alert, SafeAreaView, StyleSheet, Text, View} from 'react-native';
import CalendarView from './src/components/CalendarView';

import RandomNumberNative from './src/components/RandomNumber';
import RandomNumberKotlin from './src/components/RandomNumberKotlin';

const App = () => {
  const [date, setDate] = React.useState({});
  return (
    <SafeAreaView style={{flex: 1}}>
      <RandomNumberKotlin
        style={{flex: 1}}
        initialNumber={10}
        onNumberChange={event => {
          const number = event.nativeEvent.number;
          Alert.alert('Ini nomor anda', `${number}`);
        }}
      />
      {/* <RandomNumberNative
        style={{flex: 1}}
        initialNumber={10}
        onNumberChange={event => {
          const number = event.nativeEvent.number;
          Alert.alert('Ini nomor anda', `${number}`);
        }}
      /> */}
      {/* <View style={styles.container}>
        <CalendarView
          style={styles.calendarView}
          onDateChange={dateObject => setDate(dateObject)}
          day={20}
          month={4}
          year={2017}
        />
        <Text style={styles.instructions}>{JSON.stringify(date)}</Text>
      </View> */}
      <Text>Testing Native Module</Text>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    padding: 20,
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  calendarView: {
    width: 400,
    height: 400,
  },
});

export default App;
