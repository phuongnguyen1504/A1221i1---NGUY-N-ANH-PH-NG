import {AbstractControl} from '@angular/forms';

export function passValidator(control: AbstractControl) {
  if (control && control.value !== null || control.value !== undefined) {
    const cnfpassValue = control.value;
    const  passControl = control.root.get('password');
    if (passControl) {
      const passValue = passControl.value;
      if (passValue !== cnfpassValue) {
        return {
          isError: true
        };
      }
    }
  }
  return null;
}
export function dateValidator(control: AbstractControl) {
  if (control && control.value !== null || control.value !== undefined) {
    const dateout = control.value;
    const  datein = control.root.get('datein');
    if (datein) {
      const dateinValue = datein.value;
      if (dateinValue !== dateout) {
        return {
          isError: true
        };
      }
    }
  }
  return null;
}
