import { NativeModules, Platform } from 'react-native';

const { NavbarControl } = NativeModules;

const HideNavigationBar = () => {
  if(Platform.OS === 'android') {
    return NavbarControl.HideNavigationBar();
  } else {
    return false;
  }
};
const ShowNavigationBar = () => {
  if(Platform.OS === 'android') {
    NavbarControl.ShowNavigationBar();
  } else {
    return false;
  }
};
export { HideNavigationBar, ShowNavigationBar };
