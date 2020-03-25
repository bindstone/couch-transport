import 'semantic-ui-css/semantic.min.css'
import * as React from "react";
import {TPTable} from "./tp-table";

export const App = () => (
    <div>
        <div><h1>Header</h1></div>
        <div>
            <div><h1>Nav</h1></div>
            <div><TPTable></TPTable></div>
        </div>
    </div>
);
