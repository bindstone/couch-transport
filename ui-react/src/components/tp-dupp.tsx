import * as React from "react";

export interface AppdProps {
    compiler: string;
    framework: string;
}

export const Appd = (props: AppdProps) => (
    <h1>
        Hello from {props.compiler} and -- {props.framework}!
    </h1>
);
