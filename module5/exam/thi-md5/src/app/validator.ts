import {AbstractControl} from '@angular/forms';
import {Timestamp} from 'rxjs/internal-compatibility';
import {ValueConverter} from '@angular/compiler/src/render3/view/template';

export function passValidator(control: AbstractControl) {
  if (control && control.value !== null || control.value !== undefined) {
    const cnfpassValue = control.value;
    const passControl = control.root.get('password');
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

export function checkTimeValidator(control: AbstractControl) {
  if (control && control.value !== null || control.value !== undefined) {
    const date = control.value;
    const endDateHour = date.split(':')[0];
    const endDateMinute = date.split(':')[1];
    const endDateToMinute = Number(endDateHour) * 60 + Number(endDateMinute);
    console.log(endDateToMinute);
    console.log('gio' + endDateHour);
    console.log('phut' + endDateMinute);
    if (endDateToMinute < 30 && endDateToMinute > 1380) {
      return {
        isError: true
      };
    }
  }
  return null;
}

export function checkInOutValidator(control: AbstractControl) {
  if (control && control.value !== null || control.value !== undefined) {
    const endDate = control.value;
    const endDateHour = endDate.split(':')[0];
    const endDateMinute = endDate.split(':')[1];
    console.log(endDateHour);
    console.log(endDateMinute);
    const endDateToMinute = Number(endDateHour) * 60 + Number(endDateMinute);
    const startDate = control.root.get('startDate');

    if (startDate) {
      const startValue = startDate.value;
      const startDateHour = startValue.split(':')[0];
      const startDateMinute = startValue.split(':')[1];
      const startDateToMinute = Number(startDateHour) * 60 + Number(startDateMinute);
      if ((endDateToMinute - startDateToMinute < 300) && (endDateToMinute - startDateToMinute > 1380)) {
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
    const datein = control.root.get('datein');
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
