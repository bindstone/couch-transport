import React from 'react'
import { Subject, Observable, of } from 'rxjs';
import { ajax } from 'rxjs/ajax'

export const TPTable = () => {

    const observable$ = ajax.getJSON('/api/getall')
        .pipe(
            map(response => response),
            catchError(error => of(error))
        );

    return (<div>Hello World</div>
    );
};
