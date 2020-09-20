import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, View } from 'react-native';

import { AppLoading } from 'expo';
import { useFonts, Play_400Regular, Play_700Bold } from '@expo-google-fonts/play';

import Header from './src/components/Header';
import Routes from './src/routes';

export default function App() {

  let [fontLoaded] = useFonts({ Play_400Regular, Play_700Bold });

  if (!fontLoaded) {
    return <AppLoading />
  }
  else {
    return (
      <View style={styles.container}>
        <Routes />
        <StatusBar style="light" />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});
